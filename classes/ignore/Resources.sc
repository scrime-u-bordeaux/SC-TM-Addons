// Allocation de resources supplémentaires pour SC
Resources {
	// le rang de puissance de l'augmentation
	classvar rank;
	// les options à corriger
	classvar optNames;

	// le travail est fait lors de la compilation
	*initClass {
		var options, mult;
		// attendre que Server soit initialisé
		Class.initClassTree(Server);
		optNames = ["numAudioBusChannels", "numControlBusChannels", "numWireBufs",
			"maxNodes", "maxSynthDefs", "memSize", "numBuffers", "numRGens"];
		rank = 4;
		mult = 2 ** rank;
		// récupérer les options
		options = Server.default.options;
		optNames.do
		{|field| var getter = field.asSymbol, setter = (field ++ "_").asSymbol;
			options.perform(setter, options.perform(getter) * mult);
		};
	}

	*status {
		optNames.do {|name| "%: %".format(name,
			Server.default.options.perform(name.asSymbol)).postln;
		}
	}

	// classe abstraite, pas d'implémentation
	*new {
		Error("Abstract class % has no constructor".format(this)).throw;
	}
}
