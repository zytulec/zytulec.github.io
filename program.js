const dodaj = () => {
   const f1 = document.getElementById('f1')
   const f2 = document.getElementById('f2')

   const wynik = document.getElementById('wynik')
   wynik.innerText = Number(f1.value) + Number(f2.value)

      const wynik = document.getElementById('wynik2')
   wynik.innerText = Number(f1.value) - Number(f2.value)

      const wynik = document.getElementById('wynik3')
   wynik.innerText = Number(f1.value) * Number(f2.value)

      const wynik = document.getElementById('wynik4')
   wynik.innerText = Number(f1.value) / Number(f2.value)
}

const wyczysc = () =>{

   f1.value = ''
   f2.value = ''
   wynik.innerText = ''
}

