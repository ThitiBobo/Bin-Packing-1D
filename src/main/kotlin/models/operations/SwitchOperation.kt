package models.operations

import models.Item

class SwitchOperation(objectiveValue: Double, val item1: Item, val item2: Item): Operation(objectiveValue) {
}