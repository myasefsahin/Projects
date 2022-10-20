using System;
using System.Collections.Generic;
using System.Linq;

using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        //------------------------------------------------------------STACK---------------------------------------------------------------------------------

        Stack<string> yigin = new Stack<string>();                                          // bir yığın tanımlanır.
        private void button1_Click(object sender, EventArgs e)
        {

            if (numericUpDown1.Value == 0)                                                 // boyutun 0 olup olmadığını kontrol eder ve kullanıcıya geri bildirim döndürür.
            {
                MessageBox.Show("boyut yeterli değil lütfen boyutu arttırın " + " boyut = " + numericUpDown1.Value);
            }
            else if (listBox1.Items.Count == numericUpDown1.Value)                         // yığın boyutunun dolu olup olmadığını kontrol eder ve kullanıcıya geri bildirim döndürür. 
            {
                MessageBox.Show("maksimum boyuta ulaşıldı kitap eklemek için lütfen boyutu arttırın " + " boyut = " + numericUpDown1.Value);
            }
            else if (textBox1.Text.Length == 0)                                           // kuyruğa isimsiz bir eleman eklememek için kullanılır ve kullanıcıya geri bildirim döndürür.
            {
                MessageBox.Show("kitap adı ekleyin ");
            }
            else
            {
                yigin.Push(textBox1.Text);                                                // yazılan kitabı yığına ekler.
                listBox1.Items.Insert(0, yigin.Peek());                                   // yığına eklenen elemaı insert methodu ile yığın görünümünde listbox'a ekler.
                label3.Text = ("kitap sayısı  = " + (listBox1.Items.Count));              // her eklemede kitap sayısını yazdırır. 


            }
        }

        private void button2_Click(object sender, EventArgs e)
        {



            if (listBox1.Items.Count <= 0)                                                // yığın boşken eleman çıkaramamak için kullanılır.
            {
                MessageBox.Show("yığın boş eleman çıkarılamaz");
                textBox1.Text = "";
                label3.Text = (" kitap sayısı = 0 ");                                     //kitap sayısı sayacını tekrar sıfırlar.

            }
            else
            {
                textBox2.Text = yigin.Pop();                                             // çıkarılan elemanı üst olarak yazdırır.

                listBox1.Items.Clear();                                                  // listbox elemanlarını tamamen siler. 

                int i = 0;
                while (i < yigin.Count)                                                  // döngü yığındaki eleman sayısı kadar döner.
                {

                    listBox1.Items.Add(yigin.ElementAt(i));                              // kuyruk elemanlarını tekrar listbox'a ekler.
                    numericUpDown1.Minimum = listBox1.Items.Count;                       // boyutun azalmasını eleman sayısına sınırlar. 
                    i++;
                }


                label3.Text = ("  kitap sayısı = " + listBox1.Items.Count);              // her çıkarmada kitap sayısı sayacını azaltır.

            }




        }

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {

            numericUpDown1.Minimum = listBox1.Items.Count;                                                              // boyutu azaltmada boyutu eleman sayısına sınırlar.
            if ((numericUpDown1.Value == 0) && (numericUpDown1.Value == listBox1.Items.Count))                          //boyutun ve yığının 0 olma durumunda geri bildirim döndürür. 
            {
                MessageBox.Show("minimum boyuta ulaşıldı kitap eklenemez veya çıkarılamaz");
            }
        }

        //------------------------------------------------------------QUEUE----------------------------------------------------------------------------
        Queue<string> kuyruk = new Queue<string>();                             // kuyruk tanımlanır. 

        decimal beklemesure = 0;                                                 // her kişinin bekleme süresini tutar. 

        private void button3_Click(object sender, EventArgs e)
        {
            if (numericUpDown3.Value == 0)                                  // en başta boyutun 0 olup olmadığını kontrol eder ve kullanıcıya geri bildirim döndürür.. 
            {
                MessageBox.Show("lütfen boyutu arttırın");
            }
            else if (textBox3.Text.Length == 0)                               // kişi adı girilip girilmediğini kontrol eder ve kullanıcıya geri bildirim döndürür. 
            {
                MessageBox.Show("lütfen bir isim ekleyin");
            }
            else if (numericUpDown3.Value == listBox2.Items.Count)              // kuyruğun dolu olup olmadığını kontrol eder ve kullanıcıya geri bildirim döndürür. 
            {
                MessageBox.Show("kişi eklemek için lütfen boyutu arttırın");

            }
            else
            {
                int kisisayisi = listBox2.Items.Count;                                     // eklenen kişi sayısını tutar. 
                decimal calismasure = numericUpDown2.Value;                                // eklenen kişinin iş süresini tutar. 
                kuyruk.Enqueue(textBox3.Text + calismasure + " - " + beklemesure);         // kuyruğa kişilerin isimlerini iş süresini ve bekleme süresini ekler.
                listBox2.Items.Clear();                                                   // listbox'ı tamamen  temizler.
                int i = 0;
                while (i < kuyruk.Count)
                {
                    listBox2.Items.Add(kuyruk.ElementAt(i));                           //döngü içinde boş listbox'a her defasında yeni eleman eklenerek tüm elemanları  tekrar yazdırır. 
                    numericUpDown3.Minimum = kisisayisi;                              // boyutun küçülmesini kuyruktaki eleman sayısına sınırlar.
                    label13.Text = ("kişi sayısı = " + (kisisayisi + 1));            // her eklmede kişi sayısı sayacını arttırır.
                    i++;

                }
                beklemesure += calismasure;                                         // bekleme süresini yeni eklenen kişiler için arttırır.
            }
        }
         
        private void button4_Click(object sender, EventArgs e)
        {
            try                                                                   // kuyruğun boş olması durumunda tekrar çıkarma işlemi yapıldığında hata döndürmemek için kullanılır. 
            {
                int kisisayisi = listBox2.Items.Count;                            // kuyruktaki kişi sayısını tutar. 
                kuyruk.Dequeue();                                                // kuyuruktan eleman çıkarır. 
                listBox2.Items.Clear();                                          // listbox'ı tamamen temizler. 
                 int j = 0;                 
                while (j < kuyruk.Count)                                         // kuyruktaki eleman sayısı kadar döner.
                {
                    listBox2.Items.Add(kuyruk.ElementAt(j));                     // boş olan listboxa  baştan eleman çıkarılmış şeklide kişileri ve süre işlemlerinin tekrar yazdırır.
                    numericUpDown3.Minimum = listBox2.Items.Count;              // kuyruğun minimum boyutunu kuyruktaki kişi sayısına sınırlar. 
                    label13.Text = "kişi sayısı = " + (kisisayisi - 1);        // her çıkarımda kuyruk sayacını yazar.
                    textBox4.Text = kuyruk.Peek();                            // çıkarılan kişiyi textbox2 de görüntüler.
                    j++;  

                }
            }


            catch (InvalidOperationException)                               // kuyruğun boş olduğu durumda tekrear eleman çıkarılmaya çalışıldığında aşağıdaki işlemleri gerçekleştirir.
            {
                MessageBox.Show("kuyruk boş ");
                textBox3.Text = "";                                        // kişi isminin yazıldığı textbox'ı sıfırlar.
                
            }
        }

        private void numericUpDown3_ValueChanged(object sender, EventArgs e)
        {

            int kisisayisi = (int)listBox2.Items.Count;
            numericUpDown3.Minimum = kisisayisi;                                 //  kuyruk boyutunun minimumunu kişi sayısına sınırlar. 

            if ((numericUpDown3.Value == 0) && (listBox2.Items.Count == 0))      // kuyruk tamamen boş olduğunda geri bildirim döndürür. 
            {
                MessageBox.Show("minimum boyuta ulaşıldı kişi eklenemez veya çıkarılamaz ");
            }
        }
    }
}
 

//MUSTAFA YASEF ŞAHİN
//200757040

