package com.uta.deteccionplagas

import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.uta.deteccionplagas.databinding.ActivityControlBinding
import com.google.android.material.navigation.NavigationView

class ControlActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityControlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el NavigationView
        binding.navView.setNavigationItemSelectedListener(this)

        // Justificación del texto específico
        val specificText = "El control de enfermedades y plagas en cultivos de mora es fundamental para garantizar la salud de las plantas y la calidad de la fruta. Las enfermedades como el mildiu, la antracnosis y el tizón de la hoja pueden provocar daños irreparables en los cultivos, reduciendo la producción y disminuyendo la rentabilidad de los agricultores."+
                            "\n\nPara controlar estas enfermedades, es importante implementar medidas preventivas como la selección de variedades resistentes, la rotación de cultivos, la poda adecuada y el control de malezas. Además, el uso de fungicidas y pesticidas de manera responsable y siguiendo las indicaciones del fabricante puede ser necesario para combatir las plagas y enfermedades de forma eficaz."+
                            " \n\nEs importante que los agricultores estén capacitados en el manejo integrado de plagas y enfermedades, para minimizar el uso de productos químicos y proteger el medio ambiente."
                binding.contentText.text = specificText

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.contentText.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Maneja la selección de elementos del menú
        val contentTitle: String
        val contentSubtitle1: String
        val contentSubtitle1Text: String
        val contentSubtitle2: String
        val contentSubtitle2Text: String
        val contentText: String
        val contentImageResId: Int

        when (item.itemId) {
            R.id.control_option1 -> {
                contentTitle = "Muerte Descendente"
                contentSubtitle1 = "Descripción"
                contentSubtitle1Text = "Se observan manchas oscuras en ramas y tallos que pueden llegar a producir muerte de tejido vegetal como en ramas o la planta misma; la presencia de la enfermedad es favorecida por humedades relativas altas, presencia de malezas y problemas de aireación en el cultivo. En algunas zonas esta enfermedad es conocida como palo negro."
                contentSubtitle2 = "Manejo"
                contentSubtitle2Text = "Se recomienda podar y quemar las partes afectadas, desyerbar y hacer las limpiezas correspondientes; para prevenir el crecimiento de este hongo, se recomienda realizar aplicaciones de Trichoderma sp via foliar y en residuos de cosecha que puedan estar en el suelo; ciertas bacterias como Bacillus subtillis reportan actividad contra el patógeno."
                contentImageResId = R.drawable.image8
                contentText = "ANTRASIN P.C actúa destruyendo las paredes celulares de los hongos impidiendo su germinación y crecimiento. Adicionalmente sus componentes permiten la formación de una película en la lámina foliar que actúa como barrera protectora." +
                        "\n\nLos ingredientes activos de ANTRASIN P.C se lograron homogenizar mediante la formulación en una pasta con textura de gel que le permite una gran solubilidad en agua y una estabilidad mínima de un año" +
                        "\n\nANTRASIN es útil para el control preventivo y/o curativo de Roya y Antracnosis. Su empleo es ideal para la cicatrización de heridas después de realizar procesos de corte o podas. ANTRASIN P.C actúa como alguicida y aporta nutrientes como cobre, calcio y azufre."
            }
            R.id.control_option2 -> {
                contentTitle = "Oidium"
                contentSubtitle1 = "Descripción"
                contentSubtitle1Text = "Este es un hongo que cambia el color de las hojas y las deforma. Se localiza en ramas jóvenes, en tallos, botones y frutos; en estos tres últimos se presenta un polvillo de color blancuzco."
                contentSubtitle2 = "Manejo"
                contentSubtitle2Text = "Debido a su persistencia en residuos de cosecha, se debe mantener el cultivo limpio, con buena aireaciòn. Existen controles curativos con el uso de productos a base de polisulfuro de calcio y azufre; extractos de plantas como Rheum, tomillo, manzanilla; bacterias como Bacillus subtillis."
                contentImageResId = R.drawable.image9
                contentText = "POLYCAL es un fungicida de acción preventiva y curativa, de baja toxicidad recomendado para el control de Mildeo Polvoso (Oidium sp) en el cultivo de Rosa , mango, mora y Aguacate. Debe aplicarse como fungicida protectante en momentos donde las condiciones ambientales favorezcan el desarrollo de la enfermedad" +
                        "\n\nSe puede utilizar en diferentes etapas fenológicas del cultivo, tener en cuenta que en la etapa de floración se debe dirigir la aspersión del producto sobre el follaje de las plantas, para evitar la posible mancha de flores. Este producto no es compatible con productos de pH ácido." +
                        "\n\nPolycal es un Polisufuro de Calcio (200 g/L) utilizado para el control de patógenos que atacan raíces, tallos, follaje y frutos, cuyos componentes permiten la inhibición del crecimiento y desarrollo de microorganismos"

            }
            R.id.control_option3 -> {
                contentTitle = "Mildeo Velloso"
                contentSubtitle1 = "Descripción"
                contentSubtitle1Text = "Los síntomas de la enfermedad se presentan en coloraciones moradas sin bordes definidos, que avanzan en forma lenta hasta donde exista tejidos susceptibles. Posteriormente, los tejidos afectados se tornan más oscuros; luego, sobre los sitios donde se originó la enfermedad aparecen ampollas pequeñas de color blanquecino, que se van uniendo hasta ocasionar el cuarteamiento de la corteza. El desarrollo de la enfermedad dentro del cultivo es lento; inicialmente, disminuye la producción del tallo o la rama donde aparecen los primeros signos, luego sobreviene la muerte."
                contentSubtitle2 = "Manejo"
                contentSubtitle2Text = "El hongo no se presenta con frecuencia en las hojas, los signos se observan en aquellas localizadas en el tercio inferior, ocasionando una mancha con borde clorótico bien definido. Sobre el haz de las hojas se desarrollan manchas irregulares de color rojizo púrpura a pardo-oscuro, las cuales se rodean de un halo clorótico, mientras que sobre el envés se observan los signos del patógeno, que corresponden a un micelio de color marrón claro con abundante producción de esporangióforos y esporangios, lo cual genera la apariencia vellosa característica de la enfermedad."
                contentImageResId = R.drawable.image10
                contentText = "Debe aplicarse por vía terrestre o aérea, utilizando bombas manuales, de presión constante o motorizadas siguiendo los métodos de calibración recomendados, utilizando la dosis indicada por el ingeniero agrónomo." +
                        "\n\nLos equipos deben estar limpios y en perfectas condiciones de uso (calibrados), para permitir un óptimo desempeño del producto." +
                        "\n\nLlene hasta la mitad el tanque de mezcla, agregue la dosis recomendada de Potenzol 3000 SL. Agite y agregue los otros productos, luego termine de llenar con agua."

            }
            R.id.control_option4 -> {
                contentTitle = "Botrytis"
                contentSubtitle1 = "Descripción"
                contentSubtitle1Text = "Se considera una de las enfermedades más limitantes del cultivo y es producida por el hongo Botrytis cinérea. El mayor inoculo en el cultivo viene de micelio formado en tallos de mora en descomposición y hojas secas; es favorecida por bajas temperaturas y humedad relativa alta siendo los pétalos y los frutos maduros más susceptibles a la enfermedad; el micelio es la capa de color café grisáceo que se forma encima de la superficie, el cual se dispersa por el viento y la manipulación de la planta; los síntomas inician principalmente en las flores y frutos, lo cual afecta el cuajado de los frutos."
                contentSubtitle2 = "Manejo"
                contentSubtitle2Text = "Todas las plantas afectadas deben ser retiradas de la plantación, aplicando posteriormente fungicidas a base de cobre u amonios cuaternarios, en programas preventivos de esta enfermedad se pueden realizar aplicaciones de Bacillus subtillis y Verticillium lecanii."
                contentImageResId = R.drawable.image7
                contentText = "BOTRYCID SL es un fungicida biológico único con base en cepas NATURAL CONTROL de la bacteria Burkholderia vietnamiensis genomovar 5  NC601, de acción sistémica,  que a través de la producción del antibiótico pyrrolnitrin protege a la planta del ataque de  microorganismos fitopatógenos (hongos, bacterias) del suelo y del follaje, esta alta actividad biológica también se debe en parte a su gran capacidad para producir cianida de hidrogeno, gas con capacidad biocida." +
                        "\n\nBlanco biológico: Controla hongos de suelo y follaje como: Alternaria spp, Botrytis spp, Cylindrocarpon spp, Colletotrichum spp, Fusarium spp, Mycosphaerella spp, Phytophthora spp, Pythium spp, Rhizoctonia spp, Thielaviopsis spp y Verticillium spp. Es eficiente controlando las bacterias: Erwinia spp, Xanthomonas spp, Agrobacterium spp y Ralstonia spp."

            }
            R.id.control_option5 -> {
                contentTitle = "Defoliadores"
                contentSubtitle1 = "Descripción"
                contentSubtitle1Text = "Normalmente se localizan en los brotes tiernos y chupan la savia de las hojas ocasionando una deformación y un leve enrollamiento de las mismas; esto ocasiona problemas en el crecimiento de la planta. En campo se evidencia formación de fumagina."
                contentSubtitle2 = "Manejo"
                contentSubtitle2Text = "Se recomienda la aplicación de insecticidas químicos en la zonas jóvenes de la planta (consultar con un ingeniero agrónomo); existen hongos que los afectan como: Beauveria bassiana, Paecelomyces fumosuroseus, extractos de plantas del desierto a base de te, neem, aceites minerales que obstruyen sus espiráculos, entre otras prácticas pueden controlar poblaciones de esta plaga."
                contentImageResId = R.drawable.image6
                contentText = "Es un producto multisitio de origen natural que actúa como insecticida, acaricida y nematicida. Con la azadiractina como base controla plagas de suelo como nematodos impidiendo que lleguen a afectar la productividad de los cultivos." +
                        "\n\nEs un insecticida botánico y como tal no tiene efecto KNOCK-DOWN a diferencia de los agroquímicos de uso común. El efecto es progresivo y acumulativo sobre la plaga a controlar."
            }
            else -> {
                contentTitle = "Título Principal"
                contentSubtitle1 = "Subtítulo 1 Principal"
                contentSubtitle1Text = "Texto después del Subtítulo 1 Principal."
                contentSubtitle2 = "Subtítulo 2 Principal"
                contentSubtitle2Text = "Texto después del Subtítulo 2 Principal."
                contentText = "Este es el contenido principal.\n\nAquí hay más información."
                contentImageResId = 0 // Sin imagen
            }
        }

        binding.contentTitle.text = contentTitle
        binding.contentTitle.visibility = android.view.View.VISIBLE

        binding.contentSubtitle1.text = contentSubtitle1
        binding.contentSubtitle1.visibility = android.view.View.VISIBLE

        binding.contentSubtitle1Text.text = contentSubtitle1Text
        binding.contentSubtitle1Text.visibility = android.view.View.VISIBLE

        binding.contentSubtitle2.text = contentSubtitle2
        binding.contentSubtitle2.visibility = android.view.View.VISIBLE

        binding.contentSubtitle2Text.text = contentSubtitle2Text
        binding.contentSubtitle2Text.visibility = android.view.View.VISIBLE

        if (contentImageResId != 0) {
            binding.contentImage.setImageResource(contentImageResId)
            binding.contentImage.visibility = android.view.View.VISIBLE
        } else {
            binding.contentImage.visibility = android.view.View.GONE
        }

        binding.contentText.text = contentText

        // Justificación del texto específico
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.contentText.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.contentText.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
            binding.contentSubtitle1Text.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
            binding.contentSubtitle2Text.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }


        // Cierra el menú lateral
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

