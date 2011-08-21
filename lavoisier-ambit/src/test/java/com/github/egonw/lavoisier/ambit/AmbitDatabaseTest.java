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
package com.github.egonw.lavoisier.ambit;

import org.junit.Assert;
import org.junit.Test;

import com.github.egonw.lavoisier.IChemDatabase;
import com.github.egonw.lavoisier.IIdentifier;
import com.github.egonw.lavoisier.IProperty;
import com.github.egonw.lavoisier.Identifier;
import com.github.egonw.lavoisier.Property;

public class AmbitDatabaseTest {

    @Test
    public void testGetInstance() {
        IChemDatabase database = new AmbitDatabase();
        Assert.assertNotNull(database);
    }

    @Test
    public void testAddGetMolecule() {
        IChemDatabase database = new AmbitDatabase();
        String molecule = "CCC"; // SMILES
        Assert.assertNotNull(database);
        IIdentifier ident = new Identifier(
            CustomIndentifier.getInstance(),
            "1"
        ); 
        database.add(
            ident, molecule
        );
        Assert.assertEquals(
            molecule,
            database.get(ident)
        );
    }
        
    @Test
    public void testAddGetProperty() {
        IChemDatabase database = new AmbitDatabase();
        Assert.assertNotNull(database);
        IIdentifier ident = new Identifier(
            CustomIndentifier.getInstance(),
            "1"
        );
        IProperty property = new Property(Name.getInstance(), "foo");
        database.addProperty(ident, property);
        Assert.assertEquals(
            property,
            database.getProperty(ident, Name.getInstance())
        );
    }
}
