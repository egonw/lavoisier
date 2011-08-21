/* Copyright (C) 2011 by Egon Willighagen <egonw@users.sourceforge.net>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.egonw.lavoisier.brain;

import java.util.HashMap;
import java.util.Map;

import com.github.egonw.lavoisier.IChemDatabase;
import com.github.egonw.lavoisier.IIdentifier;
import com.github.egonw.lavoisier.IProperty;
import com.github.egonw.lavoisier.IPropertyType;

public class InMemoryDatabase implements IChemDatabase {

    private Map<IIdentifier,String> data;
    private Map<IIdentifier,Map<IPropertyType,IProperty>> properties;
    
    public InMemoryDatabase() {
        data = new HashMap<IIdentifier, String>();
        properties = new HashMap<IIdentifier, Map<IPropertyType,IProperty>>();
    }

    @Override
    public String get(IIdentifier identifier) {
        return data.get(identifier);
    }

    @Override
    public void add(IIdentifier identifier, String molecule) {
        data.put(identifier, molecule);
    }

    @Override
    public IProperty getProperty(IIdentifier identifier, IPropertyType property) {
        Map<IPropertyType,IProperty> molProps = properties.get(identifier);
        if (molProps == null) return null;
        return molProps.get(property);
    }

    @Override
    public void addProperty(IIdentifier identifier, IProperty property) {
        if (identifier == null) throw new IllegalArgumentException("Identifier was null");
        if (property == null) throw new IllegalArgumentException("Property was null");
        Map<IPropertyType,IProperty> molProps = properties.get(identifier);
        if (molProps == null) {
            molProps = new HashMap<IPropertyType, IProperty>();
            properties.put(identifier, molProps);
        }
        molProps.put(property.getType(), property);
    }

}
