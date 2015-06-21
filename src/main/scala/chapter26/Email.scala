package chapter26

object Email {
  def apply(user: String, domain: String): String = user + "@" + domain

  def unapply(str: String): Option[(String, String)] = {
    val parts = str.split("@")
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }

  def main(args: Array[String]) {
    def printEmail(s: String) {
      s match {
        case Email(u, d) => println(s"username: $u, domain: $d")
        case _ => println("not email")
      }
    }
    printEmail("foo@bar.jp")
    printEmail("foo")
    println()

    def printEmail2(s: String) {
      s match {
        case Email(Twice(u @ UpperCase()), d) => println(s"username: $u")
        case _ => println("not uppercase double username email")
      }
    }
    printEmail2("FOOFOO@bar.jp")
    printEmail2("foo")
    printEmail2("FOO@bar.jp")
    printEmail2("foofoo@bar.jp")
    println()

    def isBobInDotCom(s: String): Boolean = s match {
      case Email("bob", Domain("com", _*)) => true
      case _ => false
    }
    println(s"""isBobInDotCom("bob@scala.com"): ${isBobInDotCom("bob@scala.com")}""")
    println(s"""isBobInDotCom("andy@scala.com"): ${isBobInDotCom("andy@scala.com")}""")
    println(s"""isBobInDotCom("bob@scala.com"): ${isBobInDotCom("bob@scala.com")}""")
    println()

    val ExpandedEmail(name, top, subs @ _*) = "foo@ec.bar.com"
    println(s"name: $name")
    println(s"top: $top")
    println(s"subs: $subs")
  }
}

object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }
}

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}

object Domain {
  def apply(parts: String*): String = parts.reverse.mkString(".")
  def unapplySeq(whole: String): Option[Seq[String]] = Some(whole.split("\\.").reverse)
}

object ExpandedEmail {
  def unapplySeq(s: String):Option[(String, Seq[String])] = {
    val parts = s.split("@")
    if (parts.length == 2) {
      Some(parts(0), parts(1).split("\\.").reverse.toSeq)
    } else {
      None
    }
  }
}

