# Dungeons and Dragons Character Super/Subclass
___
**Objective:** The popular tabletop role-playing game *Dungeons and Dragons* features many ways to create your homebrewed-hero. One of the most important aspects of character creation involves that of choosing a character class. Today, we'll create a superclass called **Character**, and add one or more subclasses which modify the existing class.

# Part I: The Superclass
___
Today, we'll create a class with the following attributes and functions

**Instance Variables**
- Strength (STR) - A value between 1 and 20
- Dexterity (DEX) - A value between 1 and 20
- Constitution (CON) - A value between 1 and 20
- Intelligence (INT) - A value between 1 and 20
- Wisdom (WIS) - A value between 1 and 20
- Charisma (CHA) - A value between 1 and 20
- Name - The String name of the character
- Level - An integer representing the character's level
- Hit Points (HP) - An integer representing the character's current health
- Armor Class (AC) - An integer representing the score to beat in order to do damage to a character
- Feats - An ArrayList containing special labels for the character to gain as skills.

**Class Functions**
- **Character()** - default constructor, Creates a generic class with name "Player" and Level 1. All ability scores are set to 10, and we initialize the *feats* list. We also calculate the HP and AC of the class.
- **Character(String name, int level)** - Constructor which creates a character of *name* and *level*. Each ability score is the sum of the highest 3 values rolled by a "six-sided die", and we initialize the feats list. We also calculate the HP and AC of the class.
- **calculateHitPoints()** - In D&D, hit points are calculated by the following:
	- (*at level 1*): 10 + the ability modifier for Constitution.
	- (*at higher levels*): The existing HP + (Current level - 1) * (6 + Constitution Ability Modifier)
- **calculateArmorClass()** - 10 + Dexterity Ability Modifier
- **getAbilityModifier(int score)** - Returns the current "bonus" value from a certain ability level (STR, DEX, CON, INT, WIS, CHA)
	- (Current Ability score - 10) / 2 (*rounded down*)
- **levelUp**() - Increments the current character level, and recalculates the HP and AC of the class
- **addFeat(String feat)** - Add the corresponding feature to the feature ArrayList
- **toString() -** Prints out a formatted String of all the character's attribute values as/similar to the following:
	- Character: (name) Level: (level) Class
	- HP: # | AC: #
	- STR: # | DEX: # | CON: #
	- INT # | WIS: # | CHA: #
	- Feats: (feature list)

# Part II: The Subclass
___
Using the *Character* class we just created, extend it and add a constructor that augments the ability scores using the table below. Additionally, add the two existing features to the feats array.

| Class     | Modifiers        | Additional Features                       |
| --------- | ---------------- | ----------------------------------------- |
| Barbarian | +2 STR<br>+1 CON | - Rage<br>- Unarmored Defense             |
| Bard      | +2 CHA<br>+1 DEX | - Inspiration<br>- Jack of all Trades     |
| Cleric    | +2 WIS<br>+1 CON | - Channel Divinity<br>- Turn Undead       |
| Druid     | +2 WIS<br>+1 CON | - Wild Shape<br>- Commune with Nature     |
| Fighter   | +2 DEX<br>+1 CON | - Action Surge<br>- Second Wind           |
| Monk      | +2 DEX<br>+1 WIS | - Unarmored Movement<br>- Stunning Strike |
| Paladin   | +2 STR<br>+1 CHA | - Divine Smite<br>- Aura of Protection    |
| Ranger    | +2 DEX<br>+1 WIS | - Favored Enemy<br>- Surefooted           |
| Rogue     | +2 DEX<br>+1 INT | - Sneak Attack<br>- Uncanny Dodge         |
| Sorcerer  | +2 CHA<br>+1 CON | - Wild Magic<br>- Flexible Spellcasting   |
| Warlock   | +2 CHA<br>+1 CON | - Eldritch Patron<br>- Pact Magic         |
| Wizard    | +2 INT<br>+1 CON | - Arcane Recovery<br>- Spell Mastery      |

