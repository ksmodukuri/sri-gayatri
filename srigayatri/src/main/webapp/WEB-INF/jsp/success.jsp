<script>
$(document).ready(function(){
	$("#exampleModalCenter").modal('show');
});
</script>
<div class="modal fade modal-success" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Success <svg
							class="lexicon-icon lexicon-icon-check-circle-full"
							focusable="false"
							role="presentation"
						>
							<use
								href="/images/icons/icons.svg#check-circle-full"
							></use>
						</svg></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <svg
						class="lexicon-icon lexicon-icon-times"
						focusable="false"
						role="presentation"
					>
						<use href="/images/icons/icons.svg#times"></use>
					</svg>
        </button>
      </div>
      <div class="modal-body">
        Data Saved Successfully
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="javascript:location='dashboard'">Save changes</button>
      </div>
    </div>
  </div>
</div>