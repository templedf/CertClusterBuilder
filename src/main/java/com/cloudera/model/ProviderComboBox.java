package com.cloudera.model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;

import com.google.common.collect.Maps;

public class ProviderComboBox extends JComboBox {

    public ProviderComboBox(final Map<String, Boolean> nameAndEnabled) {
        final ListCellRenderer r = getRenderer();
        setRenderer(new ListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value,
                                 int index, boolean isSelected, boolean cellHasFocus) {
                Component c = r.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
                c.setEnabled(nameAndEnabled.get(value));
                return c;
            }
        });
    }
}

