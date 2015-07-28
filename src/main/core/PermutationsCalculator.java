package main.core;

import java.util.ArrayList;

public class PermutationsCalculator<T> {

	public ArrayList<ArrayList<T>> calculate(ArrayList<T> collection) {
		ArrayList<ArrayList<T>> permutations = new ArrayList<ArrayList<T>>();
		if (collection.isEmpty())
			return permutations;
		else if (collection.size() == 1) {
			permutations.add(collection);
			return permutations;
		} else {
			for (int i = 0; i < collection.size(); i++) {
//				addPermutations(optionStartingWith(i).combineWith(allPermutationsRemoving(i));
//				combine(collectionWithElement(i)).with(allPermutationsRemoving(i));
				addPermutationsWithCurrentElementOnFirstPosition(collection, permutations, i);
			}
			return permutations;
		}
	}

	private void addPermutationsWithCurrentElementOnFirstPosition(ArrayList<T> collection,
			ArrayList<ArrayList<T>> permutations, int i) {
		permutations.addAll(combineElementWithLists(collection.get(i), computePermutationsRemoving(collection, i)));
	}

	private ArrayList<ArrayList<T>> computePermutationsRemoving(
			ArrayList<T> collection, int i) {
		return calculate(cloneRemoving(collection,i));
	}

	private ArrayList<ArrayList<T>> combineElementWithLists(
			T element, ArrayList<ArrayList<T>> restOfPermutations) {
		ArrayList<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
		for (ArrayList<T> currentElement: restOfPermutations) {
			ArrayList<T> option = new ArrayList<T>();
			option.add(element);
			option.addAll(currentElement);
			result.add(option);
		}
		return result;
	}

	private ArrayList<T> cloneRemoving(ArrayList<T> collection,
			int index) {
		ArrayList<T> list = new ArrayList<T>(collection);
		list.remove(index);
		return list;

	}

}
