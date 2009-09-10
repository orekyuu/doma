/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.seasar.doma.domain;

import java.sql.Blob;

/**
 * {@link Blob} を値の型とする組み込みのドメインです。
 * 
 * @author taedium
 * 
 */
public final class BuiltinBlobDomain extends BlobDomain<BuiltinBlobDomain> {

    /**
     * デフォルトの値でインスタンス化します。
     */
    public BuiltinBlobDomain() {
    }

    /**
     * 値を指定してインスタンス化します。
     * 
     * @param value
     *            値
     */
    public BuiltinBlobDomain(Blob value) {
        super(value);
    }

}