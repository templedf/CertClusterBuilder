/**
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *  - Neither the name of Sun Microsystems nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.cloudera.utils;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of TransferHandler that adds support for the import and
 * export of text using drag and drop and cut/copy/paste.
 */
public class TextTransferHandler extends TransferHandler {

    private static final Logger log = LoggerFactory.getLogger(TextTransferHandler.class);
    // Start and end position in the source text.
    // We need this information when performing a MOVE
    // in order to remove the dragged text from the source.
    Position p0 = null, p1 = null;

    /**
     * Perform the actual import. This method supports both drag and drop and
     * cut/copy/paste.
     */
    public boolean importData(TransferHandler.TransferSupport support) {
        // If we can"t handle the import, bail now.
        if (!canImport(support)) {
            return false;
        }
        // Fetch the data -- bail if this fails
        String data;
        try {
            data = (String) support.getTransferable().getTransferData(
                    DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            return false;
        } catch (java.io.IOException e) {
            return false;
        }
        JTextField tc = (JTextField) support.getComponent();
        tc.replaceSelection(data);
        return true;
    }

    /**
     * Bundle up the data for export.
     */
    public Transferable createTransferable(JComponent c) {
        JTextField source = (JTextField) c;
        int start = source.getSelectionStart();
        int end = source.getSelectionEnd();
        Document doc = source.getDocument();
        if (start == end) {
            return null;
        }
        try {
            p0 = doc.createPosition(start);
            p1 = doc.createPosition(end);
        } catch (BadLocationException e) {
            log.error(e.getLocalizedMessage());
        }
        String data = source.getSelectedText();
        return new StringSelection(data);
    }

    /**
     * These text fields handle both copy and move actions.
     */
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    /**
     * When the export is complete, remove the old text if the action was a
     * move.
     */
    public void exportDone(JComponent c, Transferable data, int action) {
        if (action != MOVE) {
            return;
        }
        if ((p0 != null) && (p1 != null) && (p0.getOffset() != p1.getOffset())) {
            try {
                JTextComponent tc = (JTextComponent) c;
                tc.getDocument()
                        .remove(p0.getOffset(), p1.getOffset() - p0.getOffset());
            } catch (BadLocationException e) {
                log.error(e.getLocalizedMessage());
            }
        }
    }

    /**
     * We only support importing strings.
     */
    public boolean canImport(TransferHandler.TransferSupport support) {
        // we only import Strings
        if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }
}