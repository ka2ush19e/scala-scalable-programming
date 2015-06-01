package bobsrockets2 {
  package navigation {
    private[bobsrockets2] class Navigator {
      protected[navigation] def useStarChart() {}
      class LegOfJourney {
        private[Navigator] val distance = 100
      }
      private[this] val speed = 200
      val distance2 = new LegOfJourney().distance
    }

    class SubNavigator extends Navigator {
      super.useStarChart()
    }

    class Navigator2 {
      def f() {
        new Navigator().useStarChart()
      }
    }
  }

  class Navigator3 {
    def f() {
//      new navigation.Navigator().useStarChart()
    }
  }

  package launch {
    import navigation._
    object Vehicle {
      private[launch] val guide = new Navigator
    }
  }
}

package bobsdelights2 {
  import bobsrockets2.navigation._
  class Vehicle {
//    val guide = new Navigator
  }
}
