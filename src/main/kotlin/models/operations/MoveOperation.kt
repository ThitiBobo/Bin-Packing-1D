package models.operations

import models.Bin
import models.Item

class MoveOperation(objectiveValue: Double, val item: Item, val bin: Bin): Operation(objectiveValue) {
}