/* 
 * Copyright 2005-2010 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 or later of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * ServiceItemRenderer.java
 *
 * Created on February 10, 2006, 10:17 PM
 *
 */

package datasoul.serviceitems;

import java.awt.Component;

/**
 *
 * @author samuelm
 */
public interface ServiceItemRenderer {
    
    public void setWidth(int width);
    
    public int getHeight();
    
    public Component getComponent(boolean selected, boolean hasFocus);
    
    public boolean getShowMark();
    
    /**
     * A mark to logically divide the slides.
     * For example can be use to divide the lyrics 
     * in chorus
     */ 
    public boolean getMark();
    
}

