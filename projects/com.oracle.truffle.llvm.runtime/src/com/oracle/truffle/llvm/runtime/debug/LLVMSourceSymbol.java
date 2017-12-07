/*
 * Copyright (c) 2017, Oracle and/or its affiliates.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.truffle.llvm.runtime.debug;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.llvm.runtime.debug.scope.LLVMSourceLocation;

public final class LLVMSourceSymbol {

    private final String name;
    private final LLVMSourceLocation location;
    private final LLVMSourceType type;
    private final boolean isStatic;

    public LLVMSourceSymbol(String name, LLVMSourceLocation location, LLVMSourceType type, boolean isStatic) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.isStatic = isStatic;
    }

    public String getName() {
        return name;
    }

    public LLVMSourceLocation getLocation() {
        return location;
    }

    public LLVMSourceType getType() {
        return type;
    }

    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    @TruffleBoundary
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final LLVMSourceSymbol symbol = (LLVMSourceSymbol) o;

        if (isStatic != symbol.isStatic) {
            return false;
        }

        if (!name.equals(symbol.name)) {
            return false;
        }

        return location != null ? !location.equals(symbol.location) : symbol.location != null;
    }

    @Override
    @TruffleBoundary
    public int hashCode() {
        return name.hashCode();
    }
}
