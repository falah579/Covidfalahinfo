package id.idn.fahru.covid19info.retrofit

import id.idn.fahru.covid19info.pojo.ResponseCountry
import id.idn.fahru.covid19info.pojo.ResponseSummary
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Imam Fahrur Rofi on 30/07/2020.
 */
interface CovidInterface {

    // Path Url yang dituju adalah https://api.covid19api.com/summary,
    // karena base url-nya https://api.covid19api.com/
    // maka hanya perlu menulis summary saja
    @GET("summary")
    // response berupa data class dari pojo ResponseSummary
    suspend fun getSummary(): Response<ResponseSummary>

    // Membuat path url untuk chart country
    // Tujuan membuat URL seperti ini
    // https://api.covid19api.com/dayone/country/indonesia
    // Bagian indonesia itu bisa diganti dengan nama negara lain
    // maka kita perlu membuatnya jadi variabel dinamis
    // variabel dinamis ditandai dengan lingkupan kurung kurawal berisi nama variabel { }
    @GET("dayone/country/{country_name}")

    // @Path berfungsi untuk mengubah nilai variabel menjadi nama negara yang diinputkan
    // Response-nya berupa list dari ResponseCountry karena data JSON jenisnya list
    suspend fun getCountryData(@Path("country_name") country_name: String): Response<List<ResponseCountry>>
}
