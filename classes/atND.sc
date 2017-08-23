+Array {
	atND {|indexes|
		if (indexes.size > 1) {
			^this[indexes.first].atND(indexes[1..])
		} {
			^this[indexes.first]
		}
	}

	putND {|indexes, item|
		if (indexes.size > 1) {
			^this[indexes.first].putND(indexes[1..], item)
		} {
			this[indexes.first] = item;
			^item;
		}
	}
}
