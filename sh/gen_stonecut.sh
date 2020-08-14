#!/bin/bash

# Note: Must be executed from within this directory.

source mc_colors.src

for c in ${MC_COLORS[@]}; do
	OUT="stonecut_${c}_brick.json"
	RECIPE_DIR="../src/main/resources/data/queerbrics/recipes"
	echo "Generating ${OUT}.."
	<recipe_template_stonecut sed "s/@COLOR/$c/g" >"${RECIPE_DIR}/${OUT}"
done
