package example.android.localmart.data.model

class StoreItemModel(val itemName : String, val itemImageUrl : String, val itemPrice : Int, val itemQty : String,
                     val itemQuantityAvl : Int, var itemQuantitySelected : Int, var isInCart : Boolean) {
}