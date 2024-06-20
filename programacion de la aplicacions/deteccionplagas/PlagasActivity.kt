package com.uta.deteccionplagas

import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.uta.deteccionplagas.databinding.ActivityPlagasBinding
import com.google.android.material.navigation.NavigationView

class PlagasActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityPlagasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlagasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el NavigationView
        binding.navView.setNavigationItemSelectedListener(this)

        // Justificación del texto específico
        val specificText = "La mora es afectada por enfermedades que atacan diferentes estructuras de la planta, como raíces, tallos, hojas, botones florales, flores y frutos, las cuales se favorecen por condiciones, como material de propagación de mala calidad, humedad relativa alta, abundancia de malezas en la plantación, falta de podas, deficiencias nutricionales, falta de labores culturales oportunas y apropiadas y susceptibilidad de los materiales." +
                "\n\nEl manejo integrado de las enfermedades de la mora contempla los factores: hospedante, patógeno y clima (ambiente), y se fundamenta en los principios de exclusión, erradicación y protección. El hospedante se maneja con el uso de material de buena calidad, tolerante a enfermedades, con la fertilización adecuada y el empleo de productos químicos."
        binding.contentText.text = specificText

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.contentText.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Maneja la selección de elementos del menú
        val contentTitle: String
        val contentText: String
        val contentImageResId: Int
        var additionalText: String? = null

        when (item.itemId) {
            R.id.menu_option1 -> {
                contentTitle = "Muerte descendente"
                contentText = "Esta enfermedad es ocasionada por Glomerella cingulata.Las especies de hongos que causan esta enfermedad se manifiestan principalmente en tallos, brotes y estructuras reproductivas, con la producción de lesiones que pueden conllevar la muerte de las ramas. Los tallos afectados presentan manchas ovaladas de color morado a café oscuro sobre las cuales aparecen puntos diminutos de color negro con masas de color amarillo intenso correspondientes a la esporulación del hongo, síntoma que se denomina lesión de tallo. " +
                        "\n\nLas manchas cubren parcialmente el tallo y progresan en su tamaño hasta comprometer gran parte de este, la rama se marchita, las hojas se tornan amarillas y se secan adheridas al tallo, posteriormente la rama muere. En otras ocasiones, la enfermedad se manifiesta con lesiones claras alrededor de las espinas o aguijones, sobre las cuales aparecen pequeños puntos negros acompañados de masas diminutas de color amarillo (esporulación del hongo), síntoma que se conoce como tuna negra. " +
                        "\n\nLos hongos causantes de la antracnosis también pueden afectar inflorescencias, brotes tiernos y frutos En las inflorescencias, la enfermedad se manifiesta con producción de necrosis (muerte de las células) de los tejidos, sobre los cuales esporula el hongo."
                contentImageResId = R.drawable.image1
            }
            R.id.menu_option2 -> {
                contentTitle = "Oidium"
                contentText = "Esta enfermedad es ocasionada por el hongo Oidium Link. El mildeo polvoso se manifiesta principalmente en las hojas jóvenes, en las que produce deformación (encrespamiento), asociada a la presencia de áreas cloróticas irregulares y difusas que se observan en la superficie de la lámina foliar." +
                        "\n\nOcasionalmente, en temporadas calurosas o bajo condiciones de invernadero, las hojas se cubren de un polvillo blanco, que corresponde al crecimiento y la esporulación del hongo. La enfermedad también afecta los botones florales y frutos en diferentes estados de desarrollo. Los botones florales alteran su desarrollo y presentan un polvillo blanco, que crece sobre su superficie." +
                        "\n\nLos frutos enfermos retrasan el crecimiento, sufren malformación y exhiben la esporulación blanquecina del hongo. Las estructuras florales y los frutos se necrosan y sobre ellos se aprecia la esporulación del patógeno. En afecciones tardías, los frutos que se alcanzan a formar pueden presentar el crecimiento del hongo, el hongo ocasiona disminución del crecimiento y la fotosíntesis e incremento de la respiración de la planta. En ocasiones, las ramas afectadas se adelgazan y toman apariencia de látigos. "
                contentImageResId = R.drawable.image2
            }
            R.id.menu_option3 -> {
                contentTitle = "Mildeo velloso "
                contentText = "Esta enfermedad es ocasionada por especies patógenas del reino Stramenopila. El mildeo velloso afecta tallos, peciolos, pedúnculos, botones florales y frutos. Los tallos y pedúnculos enfermos presentan coloraciones moradas, sobre las que ocasionalmente aparecen lesiones blancas, y sobre estas puede aparecer una vellosidad de color gris claro, que corresponde a la esporulación del patógeno." +
                        "\n\nEn los botones florales, se presentan lesiones de color café claro a negro, que progresan hasta cubrir completamente la estructura y que en general están acompañadas de lesiones con tonalidades moradas en peciolos y pedúnculos que acompañan la estructura floral; sobre las lesiones puede aparecer también la esporulación del patógeno. En los frutos afectados, se observa desarrollo irregular de las drupas, maduración desuniforme y pérdida de brillo, lo cual demerita el producto para la comercialización. Los frutos verdes detienen el crecimiento, sufren malformaciones y se maduran prematuramente. En temporadas húmedas, el patógeno esporula sobre la superficie de los órganos afectados. "
                contentImageResId = R.drawable.image3
            }
            R.id.menu_option4 -> {
                contentTitle = "Botrytis"
                contentText = "Esta enfermedad es ocasionada por el hongo Botrytis cinérea. Es una enfermedad importante durante la etapa de producción y poscosecha; el hongo infecta los botones florales desde su apertura y se manifiesta en la fructificación y maduración, donde ocasiona necrosis y momificación de los frutos. En presencia de humedad, los frutos afectados exhiben crecimiento del hongo de aspecto afelpado de color grisáceo o verde oliva." +
                        "\n\nLos frutos en proceso de maduración presentan pudrición húmeda generalizada, con posterior crecimiento y esporulación del hongo. Los frutos se secan y se momifican adheridos al racimo. El hongo ocasionalmente puede afectar hojas, flores y pedúnculos."
                contentImageResId = R.drawable.image4
            }
            R.id.menu_option5 -> {
                contentTitle = "Defoliadores"
                contentText =
                    "La mora es una fruta perteneciente al género Rubus, que incluye muchas especies de plantas leñosas conocidas por sus frutos comestibles y apreciados por su sabor dulce y distintivo. Los cultivos de mora son de gran importancia económica en muchas partes del mundo, utilizados tanto para el consumo fresco como para la elaboración de mermeladas, jugos y otros productos." +
                            "\n\n Sin embargo, al igual que otros cultivos, las moras son susceptibles a varios tipos de plagas que pueden causar daños a las plantas y reducir la productividad de los cultivos. Las plagas defoliadoras en los cultivos de mora son especialmente problemáticas, ya que se alimentan de las hojas de la planta, lo que puede debilitarla y afectar su capacidad para realizar la fotosíntesis, lo que a su vez disminuye la producción de frutos. El control de estas plagas es fundamental para garantizar cosechas saludables y productivas."

                contentImageResId = R.drawable.image5
            }

                else -> {
                contentTitle = "Título Principal"
                contentText = "Este es el contenido principal.\n\nAquí hay más información."
                additionalText = "Texto adicional para el contenido principal."
                contentImageResId = 0 // Sin imagen
            }
        }

        binding.contentTitle.text = contentTitle
        binding.contentTitle.visibility = android.view.View.VISIBLE

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

        if (additionalText != null) {
            binding.additionalText.text = additionalText
            binding.additionalText.visibility = android.view.View.VISIBLE

            // Justificación del texto adicional
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.additionalText.justificationMode = Layout.JUSTIFICATION_MODE_INTER_WORD
            }
        } else {
            binding.additionalText.visibility = android.view.View.GONE
        }

        // Cierra el menú lateral
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
