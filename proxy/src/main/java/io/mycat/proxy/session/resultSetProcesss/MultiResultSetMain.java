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
package io.mycat.proxy.session.resultSetProcesss;

import io.mycat.proxy.packet.ColumnDefPacket;

import java.util.ArrayList;
import java.util.List;

public class MultiResultSetMain {
    public static void main(String[] args) {
        ColumnDefPacket[] columnDefPackets = {};
        RowIterator<Row> rowDataIterator = new RowIterator<>();
        List<ResultSet> resultSets = new ArrayList<>();
        ResultSetImpl resultSet = new ResultSetImpl(columnDefPackets, rowDataIterator);
        resultSets.add(resultSet);
        MultiResultSet multiResultSet = new MultiResultSetImpl(resultSets.iterator());
        multiResultSet.load();
        while (!multiResultSet.isFinished()){
            multiResultSet.run(null);
        }
    }
}
