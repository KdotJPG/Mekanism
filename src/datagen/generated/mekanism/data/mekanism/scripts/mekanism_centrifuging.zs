//Adds a Centrifuging Recipe that converts 1 mB of Gaseous Brine into 1 mB of Hydrogen Chloride.

// <recipetype:mekanism:centrifuging>.addRecipe(arg0 as string, arg1 as GasStackIngredient, arg2 as ICrTGasStack)

<recipetype:mekanism:centrifuging>.addRecipe("centrifuge_brine", mekanism.api.ingredient.ChemicalStackIngredient.GasStackIngredient.from(<gas:mekanism:brine>), <gas:mekanism:hydrogen_chloride>);
//An alternate implementation of the above recipe are shown commented below. This implementation makes use of implicit casting to allow easier calling:
// <recipetype:mekanism:centrifuging>.addRecipe("centrifuge_brine", <gas:mekanism:brine>, <gas:mekanism:hydrogen_chloride>);


//Removes the Centrifuging Recipe for producing Plutonium from Nuclear Waste.

// <recipetype:mekanism:centrifuging>.removeByName(name as string)

<recipetype:mekanism:centrifuging>.removeByName("mekanism:processing/lategame/plutonium");