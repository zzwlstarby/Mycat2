/**
 * Copyright (C) <2019>  <chen junwen>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.mycat.beans.mysql;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MySQLCollationIndex {
    /**
     * collationIndex 和 charsetName 的映射
     */
    public final Map<Integer, String> INDEX_TO_CHARSET = new HashMap<>();
    /**
     * charsetName 到 默认collationIndex 的映射
     */
    public final Map<String, Integer> CHARSET_TO_INDEX = new HashMap<>();

    public void put(Integer index, String charset) {
        INDEX_TO_CHARSET.put(index, charset);
        CHARSET_TO_INDEX.put(charset, index);
    }

    public String getCharsetByIndex(Integer integer) {
        return INDEX_TO_CHARSET.get(integer);
    }

    public Integer getIndexByCharset(String charset) {
        return CHARSET_TO_INDEX.get(charset);
    }

    public boolean isEmpty() {
        return INDEX_TO_CHARSET.isEmpty() || CHARSET_TO_INDEX.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLCollationIndex that = (MySQLCollationIndex) o;
        return Objects.equals(INDEX_TO_CHARSET, that.INDEX_TO_CHARSET) &&
                Objects.equals(CHARSET_TO_INDEX, that.CHARSET_TO_INDEX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INDEX_TO_CHARSET, CHARSET_TO_INDEX);
    }
}
