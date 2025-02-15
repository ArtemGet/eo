/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2025 Objectionary.com
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

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

Path binaries = basedir.toPath()
    .resolve('target')
    .resolve('classes')
    .resolve('org')
    .resolve('eolang')
Path classes = basedir.toPath()
    .resolve('src')
    .resolve('main')
    .resolve('java')
    .resolve('org')
    .resolve('eolang')

Set<String> expected = Files.walk(classes)
    .filter(path -> path.toString().endsWith('.java'))
    .map(Path::getFileName)
    .map(Path::toString)
    .map(pathName -> pathName.replace('.java', '.class'))
    .collect(Collectors.toSet())
Set<String> actual = Files.walk(binaries)
    .filter(path -> path.toString().endsWith('.class'))
    .map(Path::getFileName)
    .map(Path::toString)
    .collect(Collectors.toSet())

if (!actual.containsAll(expected)) {
    for (String must : expected) {
        if (!actual.contains(must)) {
            log.error("Missing: ${must}")
        }
    }
    fail('Not all .java files were compiled to .class files')
}
