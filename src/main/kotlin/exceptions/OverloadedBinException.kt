package exceptions

import models.Bin
import models.Item

class OverloadedBinException(item: Item, overloadedBin: Bin): Exception() {
}