import com.castres.breand.block6.p1.androidproject.Components.ComponentsItems

data class ItemRequest(
    var id: Int?,
    var prod_name: String,
    var image: String, // Change the type to String
    var price: String,
    var category: String,
    var description: String,
)

data class ItemResponse(
    val components: ComponentsItems
)
