package chpater20

class Food

abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}

class Grass extends Food

class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) {}
}

class DogFood extends Food

class Dog extends Animal {
  type SuitableFood = DogFood
  def eat(food: DogFood) {}
}

class Pasture {
  val animals: List[Animal {type SuitableFood = Grass}] = Nil
}

object Animal {
  def main(args: Array[String]) {
    val bessy = new Cow
    val lassie = new Dog
    //    lassie.eat(new bessy.SuitableFood)

    val bootsie = new Dog
    lassie.eat(new bootsie.SuitableFood)
  }
}
