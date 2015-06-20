package chapter20

object LoanPattern {
  def using[T <: {def close() : Unit}, S](obj: T)(operation: T => S) = {
    val result = operation(obj)
    obj.close()
    result
  }
}
