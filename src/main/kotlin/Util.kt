fun resourceLines(resourceName: String) =
    object {}::class.java.getResource(resourceName)!!.readText().lines()
