package com.github.jmreboreda.promo.model.exceptions.daoexceptions;

public abstract class InstanceException extends Exception {

	private static final long serialVersionUID = 2994523011175489805L;

	private Object key;
    private String className;
    
    protected InstanceException(String specificMessage, Object key, 
        String className) {
        
        super(specificMessage + " (key = '" + key + "' - className = '" + 
            className + "')");
        this.key = key;
        this.className = className;
        
    }
    
    public Object getKey() {
        return key;
    }
    
    public String getClassName() {
        return className;
    }

}
