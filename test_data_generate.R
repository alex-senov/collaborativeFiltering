N.items <- 100;
N.users <- 1000;
R.items.mean<-10
R.items.sd<-20
R.rate.mean<-5
R.rate.sd<-2

generate.user<-function(){
  user.items<-generate.items();
  result<-list()
  result$N.items<-length(user.items)
  result$items<-user.items
  result$user.rates<-generate.user.rates(result$N.items)
  return (result)
}

generate.items<-function(){
  N.user.items<-round(abs(rnorm(1,mean=R.items.mean,sd=R.items.sd)) %% N.items)
  user.items<-sample(1:N.items,size=N.user.items)  
  return (user.items)
}

generate.user.rates<-function(n){
  return (rnorm(n,mean=R.rate.mean,sd=R.rate.sd) %% 10      )
}