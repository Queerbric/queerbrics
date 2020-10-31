# Queerbrics design document

The Queerbrics mod is meant to be a community project developed by members of the similarly named discord group. The specific name of the mod must either be or contain "Queerbrics". The public advertising (Readme / CurseForge) should mention us as a Discord community (without providing a direct invite link).

## Items

To be added are variously colored brick items.

### Unicolor bricks

The mod adds 16 variants of the vanilla brick item, colored after the standard set of vanilla dyes. The items are named `<color name> Brick`. Unicolor bricks are obtained ingame by using the stone cutter on a terracotta block of the desired color. One colored terracotta block yields 4 unicolored bricks.

### Pride bricks

The mod adds N multi-colored brick variants, modeled after various LGBTQ+ flags and political orientations. Item icons are taken directly from accepted emoji in the queer discord.

Groups:

* Rainbow
* Trans Pride
* Pan Pride
* Gay Pride
* Non-Binary Pride
* Bi Pride
* Lesbian Pride
* Ace Pride
* Ancom Pride

The items are named `<group> Brick`. A pride brick is crafted by adding one matching unicolor brick per "slice" to the crafting menu. The number of resulting pride bricks is equal to the number of consumed unicolor bricks.
    
## Game mechanics

### Throwing bricks

Any of the added brick items as well as vanilla bricks can be thrown by pressing right click while held in an active hand. The flight mechanics are identical to vanilla eggs. Upon impact with an entity, they deal a set amount of damage. The amount of damage is not specific to any mob type.

*Questions:*
* *What sound is made upon impact with an entity?*
* *What sound is made upon impact with a solid block?*
* *What sound is made upon impact with a fluid?*

### Special mob interactions

Upon impact with a solid block, the flying brick despawns. Any Piglin entities in a set radius around the point of impact become "in fear" and run away from it.

### Special block interactions

#### Glass

Bricks thrown at "glass blocks" will break said blocks, destroying them in the same manner as if they had been broken with a tool. A flying brick will travel through N glass blocks, destroying them in the process, before it despawns. A "glass block" is defined as any block bearing the `GLASS` material.

#### Dispenser

A dispenser loaded with bricks should expell them in the same manner as eggs or snowballs.
