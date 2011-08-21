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
package com.github.egonw.lavoisier;

/**
 * Interface for chemical database drivers to implement
 *
 * @author egonw
 */
public interface IChemDatabase {

    /**
     * Retrieves a molecule by identifier.
     * 
     * @param  identifier {@link IIdentifier} associated with the molecule
     * @return a String representation of the molecules in a database specific format
     */
    public String get(IIdentifier identifier);

    /**
     * Adds a molecule to the database.
     * 
     * @param  identifier {@link IIdentifier} associated with the molecule
     * @param  molecule   a String representation of the molecules in a database specific format
     */
    public void add(IIdentifier identifier, String molecule);

    /**
     * Returns the value of the given property for the molecule corresponding to the
     * identifier.
     * 
     * @param  identifier {@link IIdentifier} associated with the molecule
     * @param  property   {@link IProperty} of the property to return
     * @return the IProperty for the identified molecule.
     */
    public IProperty getProperty(IIdentifier identifier, IPropertyType property);

    /**
     * Adds a property value for the molecule corresponding to the
     * identifier.
     * 
     * @param  identifier {@link IIdentifier} associated with the molecule
     * @param  property   {@link IProperty} of the property to return
     */
    public void addProperty(IIdentifier identifier, IProperty property);
}
