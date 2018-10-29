package test.rokt.mktsui.sdk.getaverage

import test.rokt.mktsui.sdk.getaverage.model.SingletonData

class GetAverage {
        fun computeAverageInt():Number {
            var result = 0.0F
            val numbers = SingletonData.getInstance().getList()
            val iterator = numbers.iterator()
            while (iterator.hasNext())
            {
                result += iterator.next().toInt()
            }
            return result / numbers.size
        }
        fun addMoreNumbers(number:Number) {
            SingletonData.getInstance().addToList(number)
        }

}