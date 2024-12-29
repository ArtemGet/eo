/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2024 Objectionary.com
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
package org.eolang.maven;

import java.io.File;
import java.nio.file.Path;

/**
 * Make program name from a path.
 *
 * @since 0.1
 */
final class Unplace {

    /**
     * The parent dir.
     */
    private final Path parent;

    /**
     * The file extension.
     */
    private final String extension;

    /**
     * Ctor.
     * @param dir The name of the parent dir
     */
    Unplace(final File dir) {
        this(dir.toPath());
    }

    /**
     * Ctor.
     * @param dir The name of the parent dir
     */
    Unplace(final Path dir) {
        this(dir, ".eo$");
    }

    /**
     * Ctor.
     * @param dir The name of the parent dir
     * @param extension The file extension
     */
    Unplace(final File dir, final String extension) {
        this(dir.toPath(), extension);
    }

    /**
     * Main Ctor.
     * @param dir The name of the parent dir
     * @param extension The file extension
     */
    Unplace(final Path dir, final String extension) {
        this.parent = dir;
        this.extension = extension;
    }

    /**
     * Make a program name.
     * @param file The file
     * @return The name of the program
     */
    public String make(final Path file) {
        return file.toString().substring(
            this.parent.toString().length() + 1
        ).replaceAll(this.extension, "").replace(File.separator, ".");
    }

}
