package chapter29

abstract class Food(val name: String) {
  override def toString = name
}

class Recipe(val name: String, val ingredients: List[Food], val instructions: String) {
  override def toString = name
}

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")

trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}

abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String): Option[Food] = allFoods.find(_.name == name)
}

trait SimpleFoods {
  object Pear extends Food("Pear")
  def allFoods: List[Food] = List(Apple, Pear)
}

trait SimpleRecipes {
  this: SimpleFoods =>
  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Pear),
    "Mix it all together"
  )
  def allRecipes: List[Recipe] = List(FruitSalad)
}

object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes with FoodCategories {
  private val categories = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar))
  )
  override def allCategories = categories
}

abstract class Browser {
  val database: Database
  def recipesUsing(food: Food): List[Recipe] = database.allRecipes.filter(_.ingredients.contains(food))
  def displayCategory(category: database.FoodCategory) = println(category)
}

object SimpleBrowser extends Browser {
  val database = SimpleDatabase
}

object GotApples {
  def main(args: Array[String]) {
    val db = SimpleDatabase
    object browser extends Browser {
      val database = db
    }
    val apple = db.foodNamed("Apple").get
    browser.recipesUsing(apple).foreach(println)
    db.allCategories.foreach(browser.displayCategory)
  }
}
