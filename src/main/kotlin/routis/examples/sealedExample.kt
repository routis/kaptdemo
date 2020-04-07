package routis.examples

import arrow.optics.optics

@optics
sealed class DomainError {

    object NetworkError : DomainError()
    @optics
    sealed class SecurityError : DomainError() {
        object NotAuthenticated : SecurityError()
        @optics
        data class NotAuthorized(val forAction: String) : SecurityError(){
            companion object
        }
        companion object
    }
    companion object
}
