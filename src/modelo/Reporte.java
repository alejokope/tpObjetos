package modelo;

public enum Reporte {
        REPORTE1("Robo del collar de perlas del museo de historia : detective\n" + 
        		"se ha sucitado el robo del siglo, seha rodado el colar de perlas\n" + 
        		"perteneciente a la antigua aristocrata Marie Sammnsung.\n" + 
        		"Dicho Artefacto es muy codiciado entre los coleccionistas mas finos\n" + 
        		"y su valor supera los 2 millones de euros"),
        REPORTE2("Asalto al millonario africano, se llevan las finas telas\n" + 
        		"hechas de seda y lino.\n" + 
        		"dichas telas son cotisadas cada una aproximadamente \n" + 
        		"30 mil dolares"),
        REPORTE3("hermosas y delicadas orquidias chinas de la dinastia Min\n" + 
        		"fueron brutalmente robadas del museo nacional en bejin\n" + 
        		"cada una esta valuada en mas de 5 mil dolares cada una\n" + 
        		"y se llevaron aproximadamente 10 set de joyas\n" + 
        		""),
        REPORTE4("trofeo y medallas del campeon argentino de taekwoondo\n" + 
        		"fueron robadas, en el medio de una entradera a su casa.\n" + 
        		"Son muy cotizadas en el mercado de subastas"),
        REPORTE5("Ojos, intestinos, corazones y demas: han asaltado\n" + 
        		"el banco de organos mas famoso del mundo\n" + 
        		"Cada organo por separado esta muy bien cotizado\n" + 
        		"en el mercado negro"),
        REPORTE6("muniecas suisa hechas de circon y diamante, expuestas en \n" +
        		"las vitrinas de famos joyeria fueron robadas la noche anterior\n" + 
        		"cada muniequita vale mas de medio millon de euros"),
        REPORTE7("llave del antiguo egipto, encontrada en la rivera del \n" + 
        		"mismo nilo es robado por un misterioso ladron.\n" + 
        		"era exhibida en el museo de historia . dicen que tiene\n" + 
        		"poderes sobre naturales"),
        REPORTE8("no te lleves mis fuentes: la noche anterior han \n" + 
        		"entrado a rrobar las fuentes de energia de famosa\n" + 
        		"empresa electrica la cuales se cotizan en mas de\n" + 
        		"un billo de dolares\n" + 
        		""),
        REPORTE9("Robo tecnologico del siglo: roban la tecnologia\n" + 
        		"mas avanzada de la tiera, un pic capaz de hacer que \n" + 
        		"cualquier estudiande pueda aprobar sus materias con un 10");

        private String value;

        private Reporte(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
}

