
var app = angular.module("payment",[]);

function keyNumberControl(evt){
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

app.controller("paymentController",["$scope","$http","$location",function($scope,$http,$location) {
    //alert(angular.element("#error").val());



    $scope.getLoadIndexPage = function(){
        $http.get("/indexPage").then(function (response) {
            $scope.toplam=0;
            response.data.forEach(function (urun) {
                console.log("EKLENMİŞ URUNLER  : " + JSON.stringify(urun));
                $scope.toplam = $scope.toplam + parseInt(urun.price);
                $scope.sepet = response.data;
            });
            const urunler = response.data;
            if(response.data.length > 0){
                $scope.IsVisible = true;
            }else{
                $scope.IsVisible = false;
            }
        });
    }

    $scope.changeCardNumber = function (text) {
        console.log("TOTAL PRİCE : " + $scope.toplam);
        if (text.length === 16) {
            var config = {
                dataType: 'application/json',
                params: {'cardNumber': $scope.cardNumber,'totalPrice' : $scope.toplam},
                headers: 'application/json'
            };
            $http.get("/installment", config).then(function (response) {
                console.log(response.data);
                var installmentDetails = response.data.installmentDetails;
                console.log(JSON.stringify(installmentDetails));
                var prices = installmentDetails[0].installmentPrices;
                console.log(JSON.stringify(prices));
                $scope.prices = prices;
                angular.forEach(prices, function (value, key) {
                    console.log("value : " + JSON.stringify(value) + " key : " + key);
                });
            });
            console.log('6 ya eşit');
        } else if ($scope.cardNumber.length < 6) {
            $scope.prices = null;
        }
    }

    $scope.selectInstallment = function (totalPrice,id) {
        console.log("İD : " +id);
        console.log("TOTAL PRİCE : " + totalPrice);
        $scope.totalPrice = totalPrice;
        console.log("TOTAL PRİCE : " + $scope.totalPrice);
    }

    $scope.cardNumberError = false;
    const errorCode = getUrlParameter("error");
    if(errorCode !== "" && errorCode !== undefined){

        $scope.name = getUrlParameter("name");
        $scope.surname = getUrlParameter("surname");
        $scope.email = getUrlParameter("email");
        $scope.phone = getUrlParameter("phone");
        console.log("ERRROR CODE : " + errorCode);
        console.log("URL LOG : " +decodeURIComponent(window.location));

        $scope.contactName = getUrlParameter("shippingName");
        $scope.identityNumber = getUrlParameter("identityNo");
        $scope.city = getUrlParameter("city");
        $scope.country = getUrlParameter("country");
        $scope.fullAddress = getUrlParameter("address");
        $scope.zipCode = getUrlParameter("zipCode");
        $scope.cardHolderName = getUrlParameter("holderName");
        $scope.cardNumber = getUrlParameter("cardNo");
        $scope.ccv = getUrlParameter("ccv");
        $scope.expireMonth =  getUrlParameter("month");
        $scope.expireYear = getUrlParameter("year");

        $scope.toplam = getUrlParameter("totalPrice");
        $scope.installment = getUrlParameter("installment");

        $scope.changeCardNumber($scope.cardNumber);
        //$scope.selectInstallment($scope.toplam,$scope.installment);

        const id = getUrlParameter("installment");
        console.log("GELEN PARAMETER : " + getUrlParameter("installment"));

        if(errorCode === "12"){
            console.log("ERROR CODE : " + errorCode);
            $("#faturaInformation").modal();
            $scope.cardNumberError = true;
            $("#cardNumberGroup").removeClass("col-sm-12");
            $("#cardNumberGroup").addClass("col-sm-8");
        }
        else if(errorCode === "13"){
            console.log("ERROR CODE : " + errorCode);
            $("#faturaInformation").modal();
            $scope.cardMonth = true;
            $("#cardMonthGroup").removeClass("col-sm-12");
            $("#cardMonthGroup").addClass("col-sm-8");
        }
        else if(errorCode === "14"){
            console.log("ERROR CODE : " + errorCode);
            $("#faturaInformation").modal();
            $scope.cardYear = true;
            $("#cardYearGroup").removeClass("col-sm-12");
            $("#cardYearGroup").addClass("col-sm-8");
        }
        else if(errorCode === "15"){
            console.log("ERROR CODE : " + errorCode);
            $("#faturaInformation").modal();
            $scope.cardCCV = true;
            $("#cardCCVGroup").removeClass("col-sm-12");
            $("#cardCCVGroup").addClass("col-sm-8");
        }else if(errorCode==="10051"){
            $("#faturaInformation").modal();
            alert("Kart bakiyesi yetersiz.");
        }else if(errorCode==="10054"){
            $("#faturaInformation").modal();
            alert("Kartınızın son kullanma tarihi geçersiz.");
        }else if(errorCode==="10093"){
            $("#faturaInformation").modal();
            alert("Kartınızın son kullanma tarihi geçersiz.");
        }else if(errorCode==="5163"){
            $("#faturaInformation").modal();
            alert("Ödeme aktif değil bankasınızla iletişime geçiniz.");
        }
        $scope.getLoadIndexPage();



    }

    $scope.getLoadIndexPage();

    app.config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);


    app.config(['$location', function($location){
        $location.html5Mode({
                enabled: true,
                requireBase: false
            }
        );
    }]);

    $scope.toplam = 0;
    $scope.urunler = [];
    $scope.add = [];
    $scope.sepet= [];
    $http.get("/urunler").then(function (response) {
        $scope.urunler = response.data;
        console.log(response)
    });

    $scope.subtractUrun = function(basketItem,index){

        $http.post("/subtractUrun",basketItem,{headers: {'Content-Type': 'application/json'}}).then(function (response) {
            $scope.toplam =0;
            $scope.add[index] = false;
            $scope.sepet = response.data;
            if(response.data.length > 0){
                $scope.IsVisible = true;
            }else $scope.IsVisible = false;
            response.data.forEach(function (urun) {
                $scope.toplam = $scope.toplam + urun.price;
            });
        });
    }
    $scope.addUrun = function (basketItem,index) {
        $http.post("/addUrun", basketItem, {headers: {'Content-Type': 'application/json'}}).then(function (response) {
            $scope.toplam =0;
            const data = response.data;
            data.forEach(function (urun) {
                $scope.toplam = $scope.toplam + urun.price;
            });
            $scope.sepet = response.data;
            console.log("RESPONSE : " + JSON.stringify(response));
            console.log("--------DATA-----------" + JSON.stringify(data));
            if(data !== ""){
                $scope.add[index] = true;
                $scope.IsVisible = true;
                $scope.urunOwner = basketItem.name;
                $("#successAddUrunModal").modal();
                setTimeout(function () {
                    $("#successAddUrunModal").modal('hide');
                }, 500);

            }

        });
    }

    $scope.faturaBilgileri = function () {
        $("#faturaInformation").modal();
    }

    $scope.paymentComplete = function () {
        var buyer = {};
        buyer.id = "1";
        buyer.name = $scope.name;
        buyer.surname = $scope.surname;
        buyer.identityNumber = $scope.identityNumber;
        buyer.email = $scope.email;
        buyer.city = $scope.city;
        buyer.country = $scope.country;
        buyer.fullAddress = $scope.fullAddress;
        buyer.contactName = $scope.contactName;
        buyer.cardHolderName = $scope.cardHolderName;
        buyer.cardNumber = $scope.cardNumber;
        buyer.expireMonth = $scope.expireMonth;
        buyer.expireYear = $scope.expireYear;
        buyer.ccv = $scope.ccv;
        var postData = angular.toJson(buyer, true);
        console.log(JSON.stringify(postData));

        $http.post("/paymentSend", postData, {
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
        }).then(function (response) {
            console.log(JSON.stringify(buyer))
            console.log(response);
        }).catch(function (err) {
            console.log(err);
        });
    }


}]);


