package nl.rug.ds.bpm.verification.comparators;

import nl.rug.ds.bpm.verification.models.kripke.State;

import java.util.Comparator;

public class StateComparator implements Comparator<State>
{
	@Override
	public int compare(State a, State b)
	{
		return a.compareTo(b);
	}
}
