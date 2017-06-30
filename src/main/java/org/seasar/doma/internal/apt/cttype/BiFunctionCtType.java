/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.apt.cttype;

import javax.lang.model.type.TypeMirror;

import org.seasar.doma.internal.apt.Context;

public class BiFunctionCtType extends AbstractCtType {

    private final CtType firstArgCtType;

    private final CtType secondArgCtType;

    private final AnyCtType resultCtType;

    BiFunctionCtType(Context ctx, TypeMirror type, 
            CtType firstArgCtType, CtType secondArgCtType,
            AnyCtType resultCtType) {
        super(ctx, type);
        this.firstArgCtType = firstArgCtType;
        this.secondArgCtType = secondArgCtType;
        this.resultCtType = resultCtType;
    }

    public CtType getFirstArgCtType() {
        return firstArgCtType;
    }

    public CtType getSecondArgCtType() {
        return secondArgCtType;
    }

    public AnyCtType getResultCtType() {
        return resultCtType;
    }

    @Override
    public <R, P, TH extends Throwable> R accept(
            CtTypeVisitor<R, P, TH> visitor, P p) throws TH {
        return visitor.visitBiFunctionCtType(this, p);
    }
}