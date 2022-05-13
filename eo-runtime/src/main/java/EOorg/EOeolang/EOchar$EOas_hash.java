/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2022 Eugene Darashkevich
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package EOorg.EOeolang;

import org.eolang.AtComposite;
import org.eolang.Data;
import org.eolang.Param;
import org.eolang.PhDefault;
import org.eolang.Phi;
import org.eolang.XmirObject;

@XmirObject(oname = "char.as-hash")
public class EOchar$EOas_hash extends PhDefault {

    public static Long hash(Character v) {
        long value = Character.getNumericValue(v);
        long res = 1L;
        long inv = (1L << 63L) - 1;
        for (int i = 0; i < 8; ++i) {
            value *= value;
            res += value ^ inv;
        }
        return res;
    }

    public EOchar$EOas_hash(final Phi sigma) {
        super(sigma);
        this.add("φ", new AtComposite(this, rho ->
                new Data.ToPhi(
                        hash(new Param(rho).strong(Character.class))
                )
        ));
    }

}
