package uz.turgunboyevjurabek.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import uz.turgunboyevjurabek.mathgame.databinding.ActivityMainBinding

import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
      var number1: Int=0
      var number2: Int=0
      var amal: Int=0
      var javop: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        checking()
        final()
    }

    fun final(){
        binding.btnOk.setOnClickListener {
            if (binding.edtJavop.text.toString().toInt()==javop){
                Toast.makeText(this, "to'g'ri", Toast.LENGTH_SHORT).show()
                checking()
            }else{
                Toast.makeText(this, "No to'g'ri", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checking():String{
        newNumber()
        var savol=""
        when(amal){
            0->{
                if (number1>=number2){
                    javop=number1-number2
                    savol= "$number1-$number2"
                    binding.thtSavol.text=savol
                }else{
                    javop=number2-number1
                    savol= "$number2-$number1"
                    binding.thtSavol.text=savol
                }
            }
            1->{
                javop=number1+number2
                savol= "$number1+$number2"
                binding.thtSavol.text=savol
            }
            2->{
                try {
                    if (number1>=number2 && number1%number2==0){
                        javop=number1/number2
                        savol= "$number1/$number2"
                        binding.thtSavol.text=savol
                    }else {
                        checking()
                    }
                }catch (e:ArithmeticException){
                    checking()
                }
            }
            3->{
                javop=number1*number2
                savol= "$number1 * $number2"
                binding.thtSavol.text=savol
            }
        }
        return savol
    }



    fun newNumber(){
        number1= Random.nextInt(10)
        number2= Random.nextInt(10)
        amal= Random.nextInt(4)
        Toast.makeText(this, "$number1", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "$number2", Toast.LENGTH_SHORT).show()

    }
}