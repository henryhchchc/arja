package us.msu.cse.repair.core.manipulation;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;

import us.msu.cse.repair.core.parser.ModificationPoint;

class InsertBeforeManipulation extends AbstractManipulation {

	public InsertBeforeManipulation(ModificationPoint mp, Statement ingredStatement, ASTRewrite rewriter) {
		super(mp, ingredStatement, rewriter);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean manipulate() {
		// TODO Auto-generated method stub
		Statement statement = mp.getStatement();
		Statement ingredStatementCopy = (Statement) ASTNode.copySubtree(statement.getAST(), ingredStatement);

		if (statement.getParent() instanceof Block) {
			Block block = (Block) statement.getParent();
			ListRewrite lrw = rewriter.getListRewrite(block, Block.STATEMENTS_PROPERTY);
			lrw.insertBefore(ingredStatementCopy, statement, null);
		} else {
			Statement statementCopy = (Statement) ASTNode.copySubtree(statement.getAST(), statement);

			Block newBlock = statement.getAST().newBlock();
			newBlock.statements().add(ingredStatementCopy);
			newBlock.statements().add(statementCopy);

			rewriter.replace(statement, newBlock, null);
		}

		return true;
	}

}
