/*
 * generated by Xtext 2.13.0
 */
package ac.soton.xeventb.xcontext.parser.antlr;

import ac.soton.xeventb.xcontext.parser.antlr.internal.InternalXContextParser;
import ac.soton.xeventb.xcontext.services.XContextGrammarAccess;
import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class XContextParser extends AbstractAntlrParser {

	@Inject
	private XContextGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS");
	}
	

	@Override
	protected InternalXContextParser createParser(XtextTokenStream stream) {
		return new InternalXContextParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "XContext";
	}

	public XContextGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XContextGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
