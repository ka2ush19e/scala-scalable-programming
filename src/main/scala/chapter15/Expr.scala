package chapter15

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {
  def main(args: Array[String]) {
    val v = Var("x")
    println(v)
    println(v.name)
    println()

    val op = BinOp("+", Number(1), v)
    println(op)
    println()

    println(op.left == Number(1))
    println()

    println(op.copy(operator = "-"))
    println()
  }

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  def simplifyAdd(expr: Expr): Expr = expr match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => expr
  }

  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplifyAll(e)
    case BinOp("+", e, Number(0)) => simplifyAll(e)
    case BinOp("*", e, Number(1)) => simplifyAll(e)
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }
}
