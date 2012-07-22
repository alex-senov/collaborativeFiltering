N.items <- 100;
N.users <- 1000;
R.items.mean<-10
R.items.sd<-20
R.rate.mean<-5
R.rate.sd<-2
F.filename<-"test_users_rates.txt"

generate.user<-function(){
  user.items<-generate.items();
  result<-list()
  result$N.items<-length(user.items)
  result$items<-user.items
  result$rates<-generate.user.rates(result$N.items)
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

append.user.to.file<-function(user,id){
  towrite<-toString(id)
  for(i in 1:user$N.items){
    towrite<-paste(toString(towrite) , ";" , toString(user$items[i]) ,",", toString(user$rates[i]),sep="")
  }
  write(towrite,file=F.filename,ncolumns=1,append=TRUE,sep="")
}

for(id in 1:N.users){
  append.user.to.file(generate.user(),id)
}