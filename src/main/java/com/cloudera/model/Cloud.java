package com.cloudera.model;

import com.google.common.base.Optional;


public class Cloud implements Comparable {

    private String displayName;
    private String provider;
    private boolean enabled;
    private Optional<String> region;
    

    public Cloud(String displayName, boolean enabled, String provider, Optional<String> region) {
        this.displayName = displayName;
        this.enabled = enabled;
        this.provider = provider;
        this.region = region;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getProvider() {
        return provider;
    }

    public Optional<String> getRegion() {
        return region;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((provider == null) ? 0 : provider.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cloud other = (Cloud) obj;
        if (displayName == null) {
            if (other.displayName != null)
                return false;
        } else if (!displayName.equals(other.displayName))
            return false;
        if (enabled != other.enabled)
            return false;
        if (provider == null) {
            if (other.provider != null)
                return false;
        } else if (!provider.equals(other.provider))
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cloud [displayName=" + displayName + ", isEnabled=" + enabled + ", provider=" + provider + (region.isPresent() ? ", region=" + region.get() : "") + "]";
    }

    @Override
    public int compareTo(Object o) {
        return this.getDisplayName().compareTo(((Cloud) o).getDisplayName());
    }
}
