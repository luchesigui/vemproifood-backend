#
# This is an example VCL file for Varnish.
#
# It does not do anything by default, delegating control to the
# builtin VCL. The builtin VCL is called when there is no explicit
# return statement.
#
# See the VCL chapters in the Users Guide at https://www.varnish-cache.org/docs/
# and http://varnish-cache.org/trac/wiki/VCLExamples for more examples.
 
# Marker to tell the VCL compiler that this VCL has been adapted to the
# new 4.0 format.
vcl 4.0;
 
import std;
import directors;
 
# Default backend definition. Set this to point to your content server.
#backend default {
#    .host = "127.0.0.1";
#    .port = "8080";
#}
 
backend web1 {
   .host = "web1";
   .port = "3000";
}
 
backend web2 {
   .host = "web2";
   .port = "3000";
}
 

sub vcl_init {
    new bar = directors.round_robin();
    bar.add_backend(web1);
    bar.add_backend(web2);
}
 
sub vcl_recv {
    set req.backend_hint = bar.backend();
}
 
sub vcl_backend_response {
#    unset beresp.http.Set-Cookie;
    set beresp.ttl = 5m;
   # set beresp.grace = 5m;
}
 
#sub vcl_deliver {
 
#    if (obj.hits > 0) {
#        set resp.http.X-Cache = "HIT";
#    } else {
#        set resp.http.X-Cache = "MISS";
#    }
#} 
