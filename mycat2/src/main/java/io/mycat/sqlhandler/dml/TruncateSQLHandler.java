package io.mycat.sqlhandler.dml;

import com.alibaba.fastsql.sql.ast.statement.SQLExprTableSource;
import com.alibaba.fastsql.sql.ast.statement.SQLTruncateStatement;
import io.mycat.MycatDataContext;
import io.mycat.sqlhandler.AbstractSQLHandler;
import io.mycat.sqlhandler.ExecuteCode;
import io.mycat.sqlhandler.SQLRequest;
import io.mycat.util.Response;



import static io.mycat.sqlhandler.dml.UpdateSQLHandler.updateHandler;


public class TruncateSQLHandler extends AbstractSQLHandler<SQLTruncateStatement> {


    @Override
    protected ExecuteCode onExecute(SQLRequest<SQLTruncateStatement> request, MycatDataContext dataContext, Response response) {
        SQLExprTableSource tableSource = request.getAst().getTableSources().get(0);
        updateHandler(request.getAst(), dataContext, tableSource, response);
        return ExecuteCode.PERFORMED;
    }
    @Override
    public ExecuteCode onExplain(SQLRequest<SQLTruncateStatement> request, MycatDataContext dataContext, Response response) {
        SQLExprTableSource tableSource = request.getAst().getTableSources().get(0);
        response.setExplainMode(true);
        updateHandler(request.getAst(), dataContext, (SQLExprTableSource) tableSource,response );
        return ExecuteCode.PERFORMED;
    }
}
