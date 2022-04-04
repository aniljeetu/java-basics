package javalang.basics.collections;

import java.util.Arrays;
import java.util.List;

public class ExchangeIndicator {

	List<String> onExchangeIndicator = Arrays.asList(new String[] {"On", "Yes", "On Exchange"});
	List<String> offExchangeIndicator = Arrays.asList(new String[] {"Off", "No", "Off Exchange"});

	private boolean canCheckExchangeIndicator(String value) {
		if(onExchangeIndicator.contains(value) || offExchangeIndicator.contains(value))
			return true;
		return false;
	}

	//prerequisite: canCheckExchangeIndicator(value) should be true
	private boolean isExchangeIndicatorOn(String value) {
		if(onExchangeIndicator.contains(value))
			return true;
		return false;
	}

	//prerequisite: canCheckExchangeIndicator(value) should be true
	public boolean isEqualExchangeIndicator(String ex1, String ex2) {
		//only two nulls can be equal
		if(ex1 == null || ex2 == null)
			return (ex1 == ex2);

		//are these valid exchange indicators
		if(!canCheckExchangeIndicator(ex1) || !canCheckExchangeIndicator(ex2))
			return false;

		if(isExchangeIndicatorOn(ex1) && isExchangeIndicatorOn(ex2))
			return true;
		if(!isExchangeIndicatorOn(ex1) && !isExchangeIndicatorOn(ex2))
			return true;
		return false;
	}

	public boolean containsExchangeIndicator(List<String> lstExAdmin, String exPPT) {
		//if value of ex is invalid
		if(!canCheckExchangeIndicator(exPPT)) {
			//check if it is null, and check if the list of exchange indicators has a null
			if(exPPT == null && lstExAdmin.contains(null)) {
				return true;
			} else {
				return false;
			}
		}
		//if we have exPPT semantically equal to one of the entries in lstExAdmin
		for(String exAdmin: lstExAdmin) {
			if(isEqualExchangeIndicator(exAdmin, exPPT))
				return true;
		}
		return false;
	}

}
